#include <iostream>
#include <set>
#include <algorithm>
using namespace std;
int main()
{
  int q;
  cin >> q;
  for(int i=0; i<q; i++){
    int n;
    cin >> n;
    int count=0;
    set<int> memo;
    memo.insert(n);
    bool bloop = false;
    while(n > 9){
      int next = 0;
      for(int j=10; j<n; j*=10){
        int a = n/j;
        int b = n%j;
        next = max(next,a*b);
      }
      if(!memo.insert(next).second){
        bloop = true;
        break;
      }
      n = next;
      count++;
    }
    if(bloop) cout << -1 << endl;
    else cout << count << endl;
  }
  return 0;
}