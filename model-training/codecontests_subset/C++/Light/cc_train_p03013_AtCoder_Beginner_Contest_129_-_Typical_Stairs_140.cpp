#include<bits/stdc++.h>
using namespace std;
int main(void){
    // Your code here!
    int n,m;
    std::cin >> n>>m;
    std::vector<int> a (n,-1);
    int i;
    int b;
    a[0]=1;
    for (i=0;i<m;i++){std::cin >> b;a[b-1]=0;}
    if(a[1]!=0)a[1]=a[0]+1;
    for (i=2;i<n;i++){
        if(a[i]!=0)a[i]=(a[i-2]+a[i-1])%1000000007;
    }
    std::cout << a[n-1]%1000000007 << std::endl;
}