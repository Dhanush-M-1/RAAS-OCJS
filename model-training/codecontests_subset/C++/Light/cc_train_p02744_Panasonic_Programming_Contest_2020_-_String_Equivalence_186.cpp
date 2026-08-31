#include<bits/stdc++.h>
using namespace std;
int n;
void dfs(string s,char c){
    if(s.length()==n){
        cout<<s<<endl;
        return ;
    }
    for(char chr='a';chr<=c+1;++chr){
        dfs(s+chr,max(c,chr));
    }
}

int main(){
    cin>>n;
    dfs("a",'a');
    return 0;
}