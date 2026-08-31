#include <bits/stdc++.h>
#define ll long long
#define rep(i,l,r) for(int (i)=(l);(i)<(r);(i)++)
using namespace std;
int n;
void dfs(string s,char max){
    if(s.length()==n)cout<<s<<endl;
    else{
        for(char c='a';c<=max;c++) dfs(s+c,((c==max)?((char)max+1):(max)));
    }    
}
int main(){
    cin>>n;
    dfs("",'a');
}