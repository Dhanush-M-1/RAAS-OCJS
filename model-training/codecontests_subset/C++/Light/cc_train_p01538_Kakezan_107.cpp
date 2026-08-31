#include <iostream>
using namespace std;

int solve(int n){
  int res = 0;

  while(n >= 10){
    int maxVal = 0;

    for(int i = 10; i <= n; i *= 10){
      maxVal = max(maxVal, (n / i) * (n % i));
    }

    n = maxVal;
    res++;
  }

  return res;
}

int main(){
  int T;
  cin >> T;

  while(T--){
    int n;
    cin >> n;
    cout << solve(n) << endl;
  }
}