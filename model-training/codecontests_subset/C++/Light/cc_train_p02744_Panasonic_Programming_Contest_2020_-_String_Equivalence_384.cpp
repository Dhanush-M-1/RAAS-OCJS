#include<iostream>
#include<algorithm>
using namespace std;
int n;
void dfs(string s,int cnt,char c){
  if(cnt==n)cout << s << endl;
  else for(char i='a';i<=c+1;i++)dfs(s+i,cnt+1,max(c,i));
}
int main(){
  cin >> n;
  dfs("a",1,'a');
}
