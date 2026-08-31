#include <bits/stdc++.h>
using namespace std;

int main() {
int A,B,C;
string S;
cin>>A>>B>>C;

  if(A+B+C-2*max(A,max(B,C))==0) S="Yes";
  else S="No";
  cout<<S;
}