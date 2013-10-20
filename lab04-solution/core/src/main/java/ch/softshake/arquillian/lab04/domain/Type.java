package ch.softshake.arquillian.lab04.domain;

public enum Type {

   LAGER("Lager"),
   PALE_ALE("Pale Ale"),
   BLOND_ALE("Blond Ale"),
   QUADRUPEL_IPA("Quadrupel India Pale Ale"),
   AMBER("Amber"),
   VIENNA("Vienna"),
   SCHWARZBIER("Schwarzbier");

   private final String label;

   private Type(String label)
   {
      this.label = label;
   }

   public String getLabel()
   {
      return label;
   }

}
