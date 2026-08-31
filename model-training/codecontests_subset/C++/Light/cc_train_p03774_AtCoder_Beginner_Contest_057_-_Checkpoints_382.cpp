#include <iostream>
#include <cmath>
using namespace std;
int N,M,A[51],B[51],C[51],D[51];

int main(){
  cin >> N >> M;
  for(int i=1;i<=N;i++){
   	cin >> A[i] >> B[i];
  }
  for(int i=1;i<=M;i++){
    cin >> C[i] >> D[i];
  }
  for(int i=1;i<=N;i++){
    int ans = -1,dist = 1e9;
    for(int j=1;j<=M;j++){
      if(dist>abs(A[i]-C[j])+abs(B[i]-D[j])){
  		ans = j;
        dist = abs(A[i]-C[j])+abs(B[i]-D[j]);
      }
    }
    cout << ans << endl;
  }
}