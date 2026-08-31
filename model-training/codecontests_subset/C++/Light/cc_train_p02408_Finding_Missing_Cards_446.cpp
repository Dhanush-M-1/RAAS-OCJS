#include <stdio.h>

int main() {
    int n, xs[52], r;
    char c, *s = "SHCD";
    for(int i=0; i<52; i++) xs[i] = 0;
    scanf("%d", &n);
    for(int i=0; i<n; i++) {
        scanf("\n%c %d", &c, &r);
        for(int j=0; j<4; j++) if(s[j] == c) xs[j*13+r-1] = 1;
    }
    for(int i=0; i<52; i++) if(xs[i] == 0) printf("%c %d\n", s[i/13], i%13+1);
}
