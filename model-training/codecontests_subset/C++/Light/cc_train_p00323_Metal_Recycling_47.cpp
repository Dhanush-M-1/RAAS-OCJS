#include <bits/stdc++.h>
using namespace std;

int m[200000+20+1];

int main() {

    int n;

    scanf("%d", &n);

    while (n--) {
        int a, b;
        scanf(" %d %d",&a,&b);
        m[a+b]++;
    }

    for(int i=0;i<200000+20;i++){
        m[i+1] += m[i]/2;
        m[i] = m[i]%2;
        if(m[i]>0){
            cout << i << " " << 0 << endl;
        }
    }



    return 0;
}