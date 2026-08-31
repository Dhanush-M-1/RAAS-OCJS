#include <bits/stdc++.h>
using namespace std;

int main() {
  int A; int B; int C;
  cin>>A>>B>>C;
  if(A+B==C||A+C==B||B+C==A)
    cout<<"Yes"<<endl;
  else cout<<"No"<<endl;
}