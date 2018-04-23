

Targets in build.xml
    clean       - delete all class, jar, docs and zip files.
    compile     - compile java source files. The class files is in the same 
                  directory.
    jars        - create socrypto.jar in directory ../lib/ext
    javadoc     - build documentation
    final_jars  - create and sign socrypto.jar
    src.zip     - create src.zip. This is zip file that contains all source file.
                  It is usefully when you what to debug jar file.
    doc.zip     - create doc.zip. Contains documentation.
    project.zip - The sructure of project. It must use to modify project.


In SOM file is included only default languages files. If you want to include
given languages in SOM file use the property "som.languages". To set this you can
do this using build.properties or setting via command line. Example of command line
    ant -Dsom.languages=fr,fr_CA som
 
If you want to include all avaliable languages files into SOM file set 
som.language to *. Example of command line
   ant -Dsom.languages=* som


Creating som files for diffrent languages.
   
   ant somlng
This command creates som files for all existing languages. For example if you hava
languages file for French and Russian this line will be create modules 
<my.module>.fr and <my.module>.ru in the following files <mysomname>_fr.som and 
<mysomname>_ru.som. Where <my.module> is the module name getting form moduleinfo.properties and
<mysomname> is a name of som file which is creating via target "som".

   ant -Dlanguages=fr
It creates only French module.

   ant -Dlanguages=fr,ru
It creates for French and Russian module.


   ant -Dlanguages=fr_CA
It creates module for French in Canada. In the module is included and files for 
default French.

