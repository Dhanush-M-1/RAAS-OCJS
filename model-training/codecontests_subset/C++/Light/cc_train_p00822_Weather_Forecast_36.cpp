#include <iostream>
#include <vector>
#include <set>
#include <utility>
const int d[] = {0,1,2,4,8,-1,-2,-4,-8}, d_[] = {0,1,4,5};
using namespace std;
int main(){
  int N;
  while(cin >> N, N){
    vector< vector<int> > V(N, vector<int>(16));
    for(int i = 0; i < N; ++i)
      for(int j = 0; j < 16; ++j) cin >> V[i][j];
    vector<int> s(16,1);
    bool f = false;
    for(int i = 0; i < 4; ++i){
      if(V[0][5+d_[i]]){
        f = true;
        break;
      }
      s[5+d_[i]] = 0;
    }
    if(f){
      cout << 0 << endl;
      continue;
    }
    set< pair<int, vector<int> > > S;
    S.insert(make_pair(5,s));
    for(int i = 1; i < N; ++i){
      set< pair<int, vector<int> > > S_;
      for(auto itr = S.begin(); itr != S.end(); ++itr){
        int t = (*itr).first;
        vector<int> v = (*itr).second;
        for(int j = 0; j < 16; ++j) ++v[j];
        for(int j = 0; j < 9; ++j){
          int t_ = t + d[j];
          if(t_ < 0 || t_%4 == 3 || t_/4 >= 3 || (t%4 != t_%4 && t/4 != t_/4)) continue;
          vector<int> v_ = v;
          bool f = false;
          for(int k = 0; k < 4; ++k){
            if(V[i][t_+d_[k]]){
              f = true;
              break;
            }
            v_[t_+d_[k]] = 0;
          }
          for(int k = 0; k < 16; ++k)
            if(v_[k] == 7) f = true;
          if(f) continue;
          S_.insert(make_pair(t_,v_));
        }
      }
      S = S_;
    }
    if(!S.empty()) cout << 1 << endl;
    else cout << 0 << endl;
  }
  return 0;
}

