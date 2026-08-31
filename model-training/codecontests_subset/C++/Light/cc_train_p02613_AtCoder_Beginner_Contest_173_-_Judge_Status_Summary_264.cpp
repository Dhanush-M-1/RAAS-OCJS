#include<bits/stdc++.h>
using namespace std;
map<string,int> M;
string Ver[]={"AC","WA","TLE","RE"};
int main()
{
  int N;
  cin>>N;
  while(N--)
  {
    string S;
    cin>>S;
    M[S]++;
  }
  for(int i=0;i<4;i++)
    cout<<Ver[i]<<" x "<<M[Ver[i]]<<endl;
  return 0;
}