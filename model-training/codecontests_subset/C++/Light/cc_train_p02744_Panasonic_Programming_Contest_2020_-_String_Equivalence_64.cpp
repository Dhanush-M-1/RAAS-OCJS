#include <bits/stdc++.h>
using namespace std;
int n;
void dfs(int i, string s, int mx){
    if(i == n){
        printf("%s\n", s.c_str());
    }
    else{
        for(char j='a';j<=mx+1;j++){
            dfs(i+1, s+j, max(mx, (int)j));
        }
    }
}
int main(){
    scanf("%d", &n);
    dfs(0, "", 'a'-1);
}