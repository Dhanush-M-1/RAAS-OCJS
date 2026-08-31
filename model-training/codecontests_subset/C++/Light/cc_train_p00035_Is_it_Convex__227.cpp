#include <iostream>
#include <sstream>
#include <string>
#include <utility>

using namespace std;
using P = pair<double,double>;
constexpr int n = 10;

double cross(const P &p1,const P &p2){
  return p1.first*p2.second - p2.first*p1.second;
}

int main(){
  string str;
  while(getline(cin,str)){
    double tmp[8];
    P p[4];
    string tmpstr;
    istringstream stream(str);
    for(int i=0;getline(stream,tmpstr,',')&&i<8;++i){
      tmp[i] = stof(tmpstr);
    }
    for(int i=0;i<4;++i){
      p[i].first = tmp[(i+1)%4*2]-tmp[i*2];
      p[i].second = tmp[(i+1)%4*2+1]-tmp[i*2+1];
      // cout << p[i].first << "," << p[i].second << endl;
    }
    
    bool allpos = true ,allneg = true;
    for(int i=0;i<4;++i){
      double val = cross(p[i],p[(i+1)%4]);
      // cout << val << endl;
      allpos = allpos && val>0;
      allneg = allneg && val<0;
    }

    bool isconvex = allneg||allpos;
    if(isconvex){
      cout << "YES" << endl;
    }else{
      cout << "NO" << endl;
    }
  }
}