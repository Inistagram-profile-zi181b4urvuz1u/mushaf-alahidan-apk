# أذان اللحيدان (Adan Alahidan) — Android APK

تطبيق أندرويد لحساب مواقيت الصلاة بالمغرب (100% بدون إنترنت) مع أذان الشيخ محمد اللحيدان.

## البنية (Structure)
- `src/config/prayer_config.json` : ملف تعديل الدقائق (Offsets) لكل صلاة.
- `src/data/morocco_localities.json` : قاعدة بيانات محلية لمدن وقرى المغرب (مستخرجة من GeoNames `MA.txt`).
- `src/utils/prayerUtils.js` : حساب المواقيت محلياً عبر مكتبة `adhan` (الفجر 19°، العشاء 17°، الشافعي/المالكي، توقيت `Africa/Casablanca`).
- `android-app/` : مشروع أندرويد الأصلي (`MainActivity.kt`, `AdhanReceiver.kt`, `AdhanService.kt`, `BootReceiver.kt`).

## تعديل دقائق الاحتياط (Offsets)
عدّل القيم في `src/config/prayer_config.json` (القيمة الافتراضية `0` لكل صلاة):
```json
{
  "fajr_offset_min": 0,
  "sunrise_offset_min": 0,
  "dhuhr_offset_min": 0,
  "asr_offset_min": 0,
  "maghrib_offset_min": 0,
  "isha_offset_min": 0
}
```
يمكنك أيضاً فتح صفحة **Debug** المخفية بالضغط **7 مرات** على عنوان **"الإعدادات"** داخل التطبيق لمعاينة الوقت الخام + التعديل + الوقت النهائي.

## إضافة مدينة أو قرية جديدة
أضف كائناً جديداً إلى `src/data/morocco_localities.json`:
```json
{ "id": "custom1", "name": "New Village", "nameAr": "القرية الجديدة", "lat": 33.0, "lng": -7.5 }
```

## البناء والتثبيت
يتم بناء ملف `app-debug.apk` تلقائياً عبر **GitHub Actions** عند كل `push` على فرع `main`، ويمكن تحميله من قسم **Releases**.
