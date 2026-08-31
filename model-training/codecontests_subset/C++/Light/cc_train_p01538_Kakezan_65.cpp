#include <iostream>
#include <vector>
using namespace std;

int main() {

  int n;
  cin >> n;

  for(int q=0;q<n;q++) {

    int s;
    cin >> s;
    
    int t = s;
    int a[2],max;
    int count = 0;
    while(t >= 10) {
      count++;
     
      a[0] = t % 10;
      t /= 10;
      a[1]  = t;
      max = a[0] * a[1];
      int k = 10;
      // cout << a[0] <<"&"<< a[1] << "||"<<a[0]*a[1]<<endl;
      while(t) {
	a[0] += k*(t%10);
	k *=10;
	t /= 10;
	a[1] = t;
	//	cout << a[0] <<"&"<< a[1] << "||"<<a[0]*a[1]<<endl;
	if(a[0] * a[1] > max) max = a[0]*a[1];

      }
      t = max;

      if(count > 50000) break;

    }

    if(t < 10) cout << count << endl;
    else cout << -1 << endl;

  }

  return 0;
}