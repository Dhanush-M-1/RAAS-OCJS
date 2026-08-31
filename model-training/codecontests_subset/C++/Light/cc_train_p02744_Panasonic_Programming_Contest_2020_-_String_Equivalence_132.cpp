#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int n;
void dfs(string s,int cnt,char c){
  if(cnt==n){
    cout << s << endl;
    return;
  }
  for(int i=0;i<c-'a'+2;i++){
    char x=i+'a';
    dfs(s+x,cnt+1,max(c,x));
  }
}
int main(){
  cin >> n;
  string s="a";
  dfs(s,1,'a');
}
