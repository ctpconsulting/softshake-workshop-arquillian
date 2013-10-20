package ch.softshake.arquillian.lab03;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Beer implements Serializable
{
   private static final long serialVersionUID = 5892013208071126314L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Basic
   @NotNull
   private String name;

   @Basic
   @NotNull
   private BigDecimal price;

   @Basic
   @NotNull
   private BigDecimal alcohol;

   protected Beer()
   {
      // to satisfy JPA
   }

   public Beer(String name, BigDecimal price, BigDecimal alcohol)
   {
      this.name = name;
      this.price = price;
      this.alcohol = alcohol;
   }

   // --- Accessor methods

   public Long getId()
   {
      return id;
   }

   protected void setId(Long id)
   {
      this.id = id;
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public BigDecimal getPrice()
   {
      return price;
   }

   public void setPrice(BigDecimal price)
   {
      this.price = price;
   }

   public BigDecimal getAlcohol()
   {
      return alcohol;
   }

   public void setAlcohol(BigDecimal alcohol)
   {
      this.alcohol = alcohol;
   }

}
