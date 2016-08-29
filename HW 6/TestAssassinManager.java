import java.util.*;
import java.lang.reflect.Field;

import junit.framework.TestCase;

public class TestAssassinManager extends TestCase
{

   public void testCreateAssassinManagerEmptyList()
   {
      boolean didThrow = false;

      try
      {
         AssassinManager manager = new AssassinManager(new ArrayList<String>());
      }
      catch (IllegalArgumentException ex)
      {
         didThrow = true;
      }

      assertTrue(didThrow);
   }

   public void testCreateAssassinManagerSingleItem()
   {
      AssassinManager manager = new AssassinManager(Arrays.asList("David"));
      AssassinNode front = getKillRingFront(manager);

      assertNotNull(front);
      assertEquals(front.name, "David");
      assertNull(front.next);
   }

   public void testCreateAssassinManagerTwoItems()
   {
      AssassinManager manager = new AssassinManager(Arrays.asList("David", "Jimmy"));
      AssassinNode front = getKillRingFront(manager);

      assertNotNull(front);
      assertEquals(front.name, "David");
      assertNotNull(front.next);
      assertEquals(front.next.name, "Jimmy");
      assertNull(front.next.next);
   }

   public void testKillRingContains()
   {
      AssassinManager manager = new AssassinManager(
            Arrays.asList("David", "Jimmy", "Heinrich"));

      assertTrue(manager.killRingContains("David"));
      assertTrue(manager.killRingContains("DAVID"));
      assertTrue(manager.killRingContains("Jimmy"));
      assertTrue(manager.killRingContains("jimmy"));
      assertTrue(manager.killRingContains("HEINRICH"));

      assertFalse(manager.killRingContains("  David  "));
      assertFalse(manager.killRingContains("Jim"));
      assertFalse(manager.killRingContains(""));
      assertFalse(manager.killRingContains("Einhorn"));

      AssassinManager manager2 = new AssassinManager(
            Arrays.asList("David"));

      assertTrue(manager2.killRingContains("david"));
   }

   public void testGameOver()
   {
      AssassinManager manager = new AssassinManager(
            Arrays.asList("David", "Jimmy", "Heinrich"));
      assertFalse(manager.isGameOver());

      AssassinManager manager2 = new AssassinManager(
            Arrays.asList("David"));

      assertTrue(manager2.isGameOver());
   }


   public void testWinner()
   {
      AssassinManager manager = new AssassinManager(
            Arrays.asList("David", "Jimmy", "Heinrich"));
      assertNull(manager.winner());

      AssassinManager manager2 = new AssassinManager(
            Arrays.asList("David"));

      assertEquals(manager2.winner(), "David");
      assertTrue(manager2.isGameOver());
   }

   public void testKillInvalidStuff()
   {
      AssassinManager manager = new AssassinManager(
            Arrays.asList("David", "Jimmy", "Heinrich", "Fred Beckey"));

      boolean didThrow = false;
      try
      {
         manager.kill("Jeff Bridges");
      }
      catch (IllegalArgumentException ex)
      {
         didThrow = true;
      }

      assertTrue(didThrow);

      didThrow = false;

      manager.kill("David");
      manager.kill("Jimmy");
      manager.kill("Heinrich");

      try
      {
         manager.kill("Fred Beckey");
      }
      catch (IllegalStateException ex)
      {
         didThrow = true;
      }

      assertTrue(didThrow);
   }

   public void testKill()
   {
      AssassinManager manager = new AssassinManager(
            Arrays.asList("David", "Jimmy", "Heinrich", "Fred Beckey"));

      assertFalse(manager.isGameOver());
      manager.kill("David");
      assertFalse(manager.killRingContains("David"));
      assertTrue(manager.killRingContains("Jimmy"));
      assertTrue(manager.killRingContains("Heinrich"));
      assertTrue(manager.killRingContains("Fred Beckey"));

      assertTrue(manager.graveyardContains("David"));
      assertFalse(manager.isGameOver());

      manager.kill("Heinrich");
      assertFalse(manager.killRingContains("David"));
      assertFalse(manager.killRingContains("Heinrich"));
      assertTrue(manager.killRingContains("Jimmy"));
      assertTrue(manager.killRingContains("Fred Beckey"));

      assertTrue(manager.graveyardContains("David"));
      assertTrue(manager.graveyardContains("Heinrich"));
      assertFalse(manager.isGameOver());

      manager.kill("Jimmy");
      assertFalse(manager.killRingContains("David"));
      assertFalse(manager.killRingContains("Heinrich"));
      assertFalse(manager.killRingContains("Jimmy"));
      assertTrue(manager.killRingContains("Fred Beckey"));

      assertTrue(manager.graveyardContains("David"));
      assertTrue(manager.graveyardContains("Heinrich"));
      assertTrue(manager.graveyardContains("Jimmy"));

      assertEquals(manager.winner(), "Fred Beckey");
      assertTrue(manager.isGameOver());
   }

   //
   // Testing utils.
   //

   /**
    * Returns the private killRingFront member variable.
    * (So we can leave it private without worrying about forgetting.)
    */
   private AssassinNode getKillRingFront(AssassinManager mgr)
   {
      Field fld;

      try
      {
         fld = AssassinManager.class.getDeclaredField("killRingFront");
      }
      catch (NoSuchFieldException ex)
      {
         System.err.println(ex.toString());
         return null;
      }

      fld.setAccessible(true);

      try
      {
         return (AssassinNode) fld.get(mgr);
      }
      catch (IllegalAccessException ex)
      {
         System.err.println(ex.toString());
         return null;
      }
   }
}