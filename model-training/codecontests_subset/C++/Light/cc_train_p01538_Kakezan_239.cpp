#include <bits/stdc++.h>
using namespace std;

#define max(a,b) ((a)>(b)?(a):(b))
#define min(a,b) ((a)<(b)?(a):(b))

typedef long long LL;

int main(){
  int q;
  cin >> q;
  int n;
  int x;
  int count;
  for(int i=0;i<q;i++){
    cin >> n;
    count=0;
    while(n>=10){
      x=0;
      for(int i=10;i<=n;i*=10){
        x=max(x,(n/i)*(n%i));
      }
      n=x;
      count++;
    }
    cout << count << endl;
  }
  return 0;
}

