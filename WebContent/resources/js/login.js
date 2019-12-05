	let lista =  document.querySelectorAll(".pagina2");
		let titulo = document.querySelector(".pagina1");


		lista.forEach((l, i) => l.classList.add("invisivel"));

		function paginacao1(){
			titulo.classList.add("fadeOut");
			lista.forEach((l, i) => l.classList.remove("fadeOut"));
			setTimeout(function(){
				lista.forEach((l, i) => l.classList.remove("invisivel"));

				titulo.classList.add("invisivel");

			},800)

		}

		function paginacao2(){
			lista.forEach((l, i) => l.classList.add("fadeOut"));
			titulo.classList.remove("fadeOut");
			setTimeout(function(){ lista.forEach((l, i) => l.classList.add("invisivel"));
				titulo.classList.remove("invisivel");},800)
		}