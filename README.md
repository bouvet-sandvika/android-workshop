# android-workshop

I denne workshopen skal vi lære grunnlegende konsepter for å lage native android apper. Appen vi skal lage består av 2 oppgaver; oppgave 1 som egner seg for nybegynnere og oppgave 2 som er litt vanskeligere.

Appen består av [MainActivity.kt](Androidworkshop/app/src/main/java/com/example/androidworkshop/MainActivity.kt) som vi kan fylle med to forksjellige fragmenter ([TipCalculatorFragment](Androidworkshop/app/src/main/java/com/example/androidworkshop/ui/tip/TipCalculatorFragment.kt) og ([TodoListFragment.kt](Androidworkshop/app/src/main/java/com/example/androidworkshop/ui/todo/TodoListFragment.kt)). Oppgave 1 og 2 er å henholdsvis implementere disse to fragmentene.

### Oppgave 1

Her skal vi lage en tips kalkulator som regner ut hvor mye tips du skal betale avhengig av tips prosent og hvor stor regningen er. Her kan man starte med å legge til de tekstfeltene vi mangler i [fragment_tip_calculator.xml](Androidworkshop/app/src/main/res/layout/fragment_tip_calculator.xml) og så implementere funksjonaliteten i [TipCalculatorFragment](Androidworkshop/app/src/main/java/com/example/androidworkshop/ui/tip/TipCalculatorFragment.kt).

### Oppgave 2

I denne oppgaven skal vi lage en klassisk to do liste. Her er det lurt å begynne å legge til de nødvendige viewsene i [fragment_todo_list.xml](Androidworkshop/app/src/main/res/layout/fragment_todo_list.xml) og så implementere funksjonaliteten i ([TodoListFragment.kt](Androidworkshop/app/src/main/java/com/example/androidworkshop/ui/todo/TodoListFragment.kt)).

**Hint!** Her trenger vi et RecyclerView for å liste ut to dos. Da må vi også implementere en RecyclerView.Adapter (https://developer.android.com/reference/androidx/recyclerview/widget/RecyclerView.Adapter) som er lagt til rette for i [TodoAdapter](https://github.com/martinbg1/android-workshop/blob/main/Androidworkshop/app/src/main/java/com/example/androidworkshop/ui/todo/TodoAdapter.kt).

Lykke til!
