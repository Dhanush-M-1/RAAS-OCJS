#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <queue>
#include <set>
#include <map>
#include <cmath>
using namespace std;
typedef long long i64;
typedef long double ld;
typedef pair<i64,i64> P;
#define rep(i,s,e) for(int (i) = (s);(i) <= (e);(i)++)

int n;

vector<int> a(1010);

int main(){
  cin >> n;
  for(int i = 0;i < n;i++){
    cin >> a[i];
  }

  rep(i,0,n - 1) rep(j,0,n - 1){
    if(i == j) continue;
    if(abs(a[i] - a[j]) % (n - 1) == 0){
      cout << a[i] << " " << a[j] << endl;
      return 0;
    }
  }
}
