package com.fustania.fustania_backend.repository;

  import com.fustania.fustania_backend.model.Dress;
  import com.fustania.fustania_backend.model.User;
  import org.springframework.data.jpa.repository.JpaRepository;
  import org.springframework.data.jpa.repository.Query;
  import org.springframework.data.repository.query.Param;

  import java.util.List;

  public interface DressRepository extends JpaRepository<Dress, Long> {
      List<Dress> findBySeller(User seller);

      @Query("SELECT d FROM Dress d WHERE "
              + "(:designer IS NULL OR LOWER(d.designer) LIKE :designer) AND "
              + "(:size IS NULL OR d.size = :size) AND "
              + "(:maxPrice IS NULL OR d.price <= :maxPrice) AND "
              + "(:color IS NULL OR LOWER(d.color) LIKE :color) AND "
              + "(:qyteti IS NULL OR LOWER(d.qyteti) LIKE :qyteti) AND "
              + "(:shteti IS NULL OR d.shteti = :shteti)")
      List<Dress> findByFilters(
              @Param("designer") String designer,
              @Param("size") String size,
              @Param("maxPrice") Double maxPrice,
              @Param("color") String color,
              @Param("qyteti") String qyteti,
              @Param("shteti") String shteti);
  }