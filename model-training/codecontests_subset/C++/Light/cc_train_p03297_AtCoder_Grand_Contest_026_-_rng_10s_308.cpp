#include <bits/stdc++.h>
using namespace std;

long long gcd(long long x, long long y){
  if (x<y) return gcd(y,x);
  else if(x%y == 0) return y;
  else return gcd(y,x%y);
}

int main(){
  int T;
  cin >> T;
  for (int i=0; i<T; i++){
    long long A, B, C, D;
    cin >> A >> B >> C >>D;
    if ((D < B) || (A < B)){
      cout <<"No" << endl;
    } else if (C >= B){
      cout << "Yes" << endl;
    } else if ((C >= B-gcd(B,D)) && (A%B <= C)){
      cout << "Yes" << endl;
    } else {
      cout << "No" << endl;
    }
  }
}
