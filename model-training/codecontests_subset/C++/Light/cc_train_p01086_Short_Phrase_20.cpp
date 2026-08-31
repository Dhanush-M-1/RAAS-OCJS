#include <bits/stdc++.h>

int n;
int L[64];
std::string str;

int main() {  
  for(;;) {
    scanf("%d", &n);
    if( n == 0 ) break;
    for(int i = 0; i < n; ++i) {
      std::cin >> str;
      L[i] = str.size();
    }
    for(int i = 0; i < n; ++i) {
      int state = 0;
      int x = 0;
      int dx[5] = {5, 7, 5, 7, 7};
      for(int j = i; j < n; ++j) {
        x += L[j];
        if( x > dx[state] ) break;
        if( x == dx[state] ) {
          x = 0;
          state += 1;
          if( state == 5 ) {
            break;
          }            
        }
      }
      if( state == 5 ) {
        printf("%d\n", i + 1);
        break;
      }
    }
  }
            

  return 0;
}