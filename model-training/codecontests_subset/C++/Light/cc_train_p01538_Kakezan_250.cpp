#include <cstdio>
#include <cstring>
#include <iostream>
#include <algorithm>
using namespace std;
int q,n;
bool f[1111111];
int main(void){
  cin >> q;
  for(int k = 0; k < q; k++){
    int c = 0;
    memset(f,false,sizeof(f));
    cin >> n;
    while(n > 9){
      if(f[n]){
	c = -1;
	break;
      }
      f[n] = true;
      c++;
      int best = 0;
      for(int i = 10; i <= 1000000; i*=10){
	best = max(best,(n/i)*(n%i));
      }
      n = best;
    }
    cout << c << endl;
  }
}