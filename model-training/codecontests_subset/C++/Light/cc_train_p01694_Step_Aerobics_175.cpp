#include <stdio.h>

int main(void)
{
    while(true) {
        int n,res=0;
        bool l=false,r=false,last=false;

        scanf("%d", &n);
        if(!n) break;

        for(int i=0; i < n; i++) {
            char s[3];
            scanf("%s", s);
            if(s[0] == 'l')
                l = !l;
            else
                r = !r;

            if( (l == r) && (l != last) ) {
                last = !last;
                res += 1;
            }
        }
        printf("%d\n", res);
    }
    return 0;
}