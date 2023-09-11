package ipca.combustivel.cmprojetooo

class FoodMenu1 {
    var nome        :String?=null
    var preco   :String?=null
    var descricao      :String?=null
    var title  :String?=null
    var image :Int

    constructor(nome: String?, preco: String?, descricao: String?, title: String?, image :Int) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.title = title;
        this.image = image;
    }
}