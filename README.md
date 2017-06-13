# Google Batch Image Downloader (GBID)
Coded by: Mohamad Shams
Website: http://www.mshams.ir, http://tadbir.it
Contact me: info[at]mshams.ir

Ex:
    java -jar Gbid.jar -f input.txt --size larger:vga --domain www.mshams.ir --color specific:red
    java -jar Gbid.jar -f input.txt --size large --type photo -n 15 -v
    java -jar Gbid.jar -p "action script" --size large --domain www.mshams.ir
    java -jar Gbid.jar -p "white lion" --size small --ext png --type photo --color transparent
    java -jar Gbid.jar -p "beauty girl" --type face --color specific:white -v -s -n 5
    java -jar Gbid.jar -p "beauty girl" --type face --color specific:black -v -n 30 --aspect tall --size medium --rights reuse
    java -jar Gbid.jar -p "captcha" -v -n 40 -t 8 --size small --ext png
    java -jar Gbid.jar -p "logo linux" -v -n 40 --size small --ext png --color transparent

Usage:[-v|--verbose] [-h|--help] [-?] [(-p|--phrase) <phrase>] [(-f|--file) <file>] [(-t|--thread) <thread>] [(-n|--num) <num>] [(-d|--domain) <domain>] [--type <type>] [--ext <ext>] [--aspect <aspect>] [--rights <rights>] [--size size:option ] [--color color:option ]
  [-v|--verbose]
        Set verbose mode for output.

  [-h|--help]
        Show help screen.

  [-?]
        Show help screen.

  [(-p|--phrase) <phrase>]
        Double qouted search phrase. Ex: -p "White lion"

  [(-f|--file) <file>]
        Input file name.

  [(-t|--thread) <thread>]
        Maximum working threads. (default: 3)

  [(-n|--num) <num>]
        Number of results. (default: 10)

  [(-d|--domain) <domain>]
        Define search domain. Ex: -d www.mshams.ir

  [--type <type>]
        Define image type, possible values are:[face, clipart, lineart, photo,
        animated].
        Ex: --type face

  [--ext <ext>]
        Define image file extension, possible values are:[jpg, ico, bmp, svg,
        gif, png, webp].
        Ex: --ext bmp

  [--aspect <aspect>]
        Define image aspect ratio, possible values are:[square, wide,
        panoramic, tall].
        Ex: --aspect tall

  [--rights <rights>]
        Define image copyrights, possible values are:[reuse, com_reuse_modify,
        reuse_modify, com_reuse].
        Ex: --rights com_reuse

  [--size size:option ]
        Define image size, possible values are:[small, larger, large, icon,
        medium, exactly].
        Ex: --size medium

        For larger mode there are other options:[qsvga, 70mp, 40mp, svga, 15mp,
        vga, xga, 12mp, 2mp, 10mp, 20mp, 4mp, 6mp, 8mp]
        Ex: --size larger:qsvga

        For exactly mode weigth and heigth needed
        Ex: --size exactly:640,480

  [--color color:option ]
        Define image coloe, possible values are:[color, nocolor, specific,
        transparent].
        Ex: --color transparent

        For specific mode there are other options:[orange, red, pink, gray,
        green, blue, white, black, yellow, purple, teal, brown]
        Ex: --color specific:green
		
