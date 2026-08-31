#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 100000 + 10;
char s[11];
int n;
void dfs(int p,int x){
    if(p==n) printf("%s\n",s);
    else{
        for(int i=0;i<=x;i++){
            s[p] = 'a' + i;
            dfs(p+1,x+(i==x));
        }
    }
}
int main(){
    cin>>n;
    dfs(0,0);
}
