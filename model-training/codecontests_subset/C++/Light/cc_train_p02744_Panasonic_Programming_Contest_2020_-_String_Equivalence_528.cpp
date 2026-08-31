#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
char a[11];
void dfs(int n,int y,int z){
    if(y==n){
        cout<<a<<endl;
        return;
    }
    for(int i=0;i<=z;i++){
        a[y]='a'+i;
        if(i==z) dfs(n,y+1,z+1);
        else dfs(n,y+1,z);
    }
}
int main(void){
    int n;
    cin>>n;
    dfs(n,0,0);
}