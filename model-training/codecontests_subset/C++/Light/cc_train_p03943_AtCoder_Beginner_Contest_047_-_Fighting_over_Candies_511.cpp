#include<bits/stdc++.h>
using namespace std;
int main(){
  array<int,3>xs;
  for(auto&x:xs)cin>>x;
  sort(xs.begin(),xs.end());
  cout<<(xs[0]+xs[1]==xs[2]?"Yes":"No")<<endl;
}
