#include<bits/stdc++.h>
using namespace std;
 
int main()
{
  int n;
  string w[40];
  int lengths[] = {5, 7, 5, 7, 7};
 
  while(cin >> n, n) {
    for(int i = 0; i < n; i++) {
      cin >> w[i];
    }
    for(int i = 4; i < n; i++) {
      int beforreadidx = 4, len = 0;
      for(int j = i; j >= 0; j--) {
        len += w[j].length();
        if(lengths[beforreadidx] == len) {
          len = 0;
          beforreadidx--;
          if(beforreadidx == -1) {
            cout << j + 1 << endl;
            break;
          }
        }
      }
      if(beforreadidx == -1) break;
    }
  }
  return(0);
 
}