package Biblioteca;


/**
* Biblioteca/Libro.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Biblioteca.idl
* viernes 28 de marzo de 2025 18H29' CET
*/

public final class Libro implements org.omg.CORBA.portable.IDLEntity
{
  public String titulo = null;
  public String autor = null;
  public String ISBN = null;
  public boolean estaDisponible = false;

  public Libro ()
  {
  } // ctor

  public Libro (String _titulo, String _autor, String _ISBN, boolean _estaDisponible)
  {
    titulo = _titulo;
    autor = _autor;
    ISBN = _ISBN;
    estaDisponible = _estaDisponible;
  } // ctor

} // class Libro
