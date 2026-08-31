#include <bits/stdc++.h>
using namespace std;

int main(){
  while(1){
    int N, i, j, s = 0;
    scanf("%d", &N);
    if(N == 0){
      return 0;
    }
    vector<string> w(N);
    for(i = 0; i < N; i++){
      cin >> w[i];
      s += w[i].size();
    }
    vector<int> a(s + 1, 0);
    for(i = 0, j = 0; i < N; i++){
      a[j] = 1;
      j += w[i].size();
    }
    a[j] = 1;
/*    for(i = 0; i < a.size(); i++){
      printf("%d", a[i]);
    }
    printf("\n");
*/    s = 0;
    for(i = 0; i < N; i++){
//      printf("i = %d\n", i);
//      printf("s = %d\n", s);
      if(a[s] == 1 && a[s + 5] == 1 && a[s + 12] == 1 && a[s + 17] == 1 && a[s + 24] == 1 && a[s + 31] == 1){
        printf("%d\n", i + 1);
        break;
      }
      s += w[i].size();
    }
  }
}

