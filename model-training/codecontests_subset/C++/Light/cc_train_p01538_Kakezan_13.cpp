#include <bits/stdc++.h>

using namespace std;

int maxi(int n)
{
    if (n <= 9) return (0);
    
    int b = 1;
    int c = 0;
    int ma = 0;
    while (n > 9){
        c += (n % 10) * b;
        b *= 10;
        n /= 10;
        ma = max(ma, n * c);
    }
    
    return (maxi(ma) + 1);
}

int main()
{
    int Q;
    
    scanf("%d", &Q);
    
    while (Q--){
        int n;
        
        scanf("%d", &n);
        
        printf("%d\n", maxi(n));
    }
    
    return (0);
}