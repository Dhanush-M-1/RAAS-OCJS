#include<bits/stdc++.h>
using namespace std;
int n;
void dfs(string s,char mxc)
{
  if(n==s.size())
   cout << s << endl;
  else
  {
     for(char c = 'a'; c <= mxc; ++c) {
      dfs(s+c, (c==mxc?mxc+1:mxc));
     }
  }
}
int main()
{
  cin>>n;
  dfs("",'a');
}
  