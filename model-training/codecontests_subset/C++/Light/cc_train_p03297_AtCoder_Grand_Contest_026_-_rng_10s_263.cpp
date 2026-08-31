#include<iostream>
#include<algorithm>

using namespace std;

long gcd(long a, long b){
  if(b==0) return a;
  return gcd(b, a%b);
}

int main(){
  int t;
  long a, b, c, d;
  cin >> t;
  for(int i=0;i<t;i++){
    cin >> a >> b >> c >> d;
    if(a < b || d < b){
      cout << "No" << endl;
    }else if(b <= min(c, d)){
      cout << "Yes" << endl;
    }else{
      long g = gcd(b, d);
      long max_ = b - g + a % g;
      if(max_ <= c){
        cout << "Yes" << endl;
      }else{
        cout << "No" << endl;
      }
    }
  }
}