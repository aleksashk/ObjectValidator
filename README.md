Создать “общий” валидатор, который не зависит от валидируемого объекта.
Необходимо создать класс Validator:
    class Validator {
        boolean validate(Object obj);
    }
Который с помощью Reflection API будет делать валидацию полей объекта по созданным аннотациям:
@Max(int length) - максимальное значение (все Number)
@Min(int length) - минимальное значение (все Number)
@Regexp(String regexp) - подходит ли по регулярному выражению (только String)
@NotNull - применяется для всех ссылочных типов
@NotEmpty - применяется для всех наследников Collections
