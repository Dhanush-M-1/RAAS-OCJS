#include <bits/stdc++.h>
using namespace std;
 
int main() {
  int N,M;
  cin >> N >> M;
  int s[N][2];
  int p[M][2];
  for(int i=0;i<N;i++){cin >> s[i][0] >> s[i][1];}
  for(int i=0;i<M;i++){cin >> p[i][0] >> p[i][1];}
  
  for(int i=0;i<N;i++){
    int p_min;
    int d_min = pow(10,9);
    for(int j=0;j<M;j++){
      int d = abs(s[i][0]-p[j][0])+abs(s[i][1]-p[j][1]);
      if(d<d_min){
        p_min = j+1;
        d_min = d;
      }
    }
    cout << p_min << endl;
    
  }
}