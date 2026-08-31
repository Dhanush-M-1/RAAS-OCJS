#include <iostream>
#include <set>
#define llint long long

using namespace std;

llint Q;
llint n;
set<llint> S;

llint get(llint x)
{
  llint keta = 0;
  for(llint t = x; t; t/=10) keta++;
  llint mul = 10, ret = 0;
  for(int i = 0; i < keta-1; i++){
    ret = max(ret, x/mul * (x%mul));
    mul *= 10;
  }
  return ret;
}

int main(void)
{
  cin >> Q;
  for(int i = 0; i < Q; i++){
    cin >> n;
    llint ans = 0;
    S.clear();
    S.insert(n);
    while(1){
      if(n < 10){
        cout << ans << endl;
        break;
      }
      n = get(n);
      ans++;
      if(S.count(n)){
        cout << -1 << endl;
        break;
      }
      S.insert(n);
    }
  }
  return 0;
}

