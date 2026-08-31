//03
#include<iostream>
#include<string>

using namespace std;

int mem[500][500][10][3];
int m;

int rec(int rd,int r,int l,int d){
  if(rd==0){
    return r==0;
  }else if(mem[rd][r][l][d]!=-1){
    return mem[rd][r][l][d];
  }else{
    int re=0;
    for(int i=0;i<10;i++){
      if(i!=l&&(l<i)!=d){
	re=(re+rec(rd-1,(r*10+i)%m,i,l<i))%10000;
      }
    }
    return mem[rd][r][l][d]=re;
  }
}

int rrec(string s,int l,int r,int d){
  if(s==""){
    return r==0;
  }else{
    int re=0;
    int i;
    for(i=0;i<s[0]-'0';i++){
      if(l!=i&&(l<i)!=d){
	re=(re+rec(s.size()-1,(r*10+i)%m,i,l<i))%10000;
      }
    }
    if(l!=i&&(l<i)!=d){
      re=(re+rrec(s.substr(1),s[0]-'0',(r*10+s[0]-'0')%m,l<i))%10000;
    }
    return re;
  }
}

int zzn(string s){
  int r=0;
  if(s.size()>=2){
    int h=(s[0]-'0')*10+s[1]-'0';
    for(int i=10;i<h;i++){
      if(i%10!=i/10){
	r=(r+rec(s.size()-2,i%m,i%10,i%10>i/10))%10000;
      }
    }
    if(s[0]!=s[1]){
      r=(r+rrec(s.substr(2),h%10,h%m,s[1]>s[0]))%10000;
    }
    for(int i=3;i<=s.size();i++){
      for(int j=10;j<99;j++){
	if(j%10!=j/10){
	  r=(r+rec(s.size()-i,j%m,j%10,j%10>j/10))%10000;
	}
      }
    }
    r=(r+(9/m)+1)%10000;
    return r;
  }else{
    return (s[0]-'0')/m+1;
  }
}

// #include<sstream>
// int main(){
//   fill(mem[0][0][0],mem[500][0][0],-1);
//   m=1;
//   int l=0;
//   for(int i=0;i<100000;i++){
//     stringstream ss;
//     ss<<i;
//     int c=zzn(ss.str());
//     if(c!=l){
//       cout<<i<<endl;
//       l=c;
//     }
//   }
// }

int main(){
  fill(mem[0][0][0],mem[500][0][0],-1);
  string a,b;
  cin>>a>>b>>m;
  bool zzm=false;
  int r=0;
  for(int i=0;i<a.size();i++){
    r=(r*10+a[i]-'0')%m;
  }
  if(r==0){
    int i;
    int d=2;
    for(i=0;i<a.size()-1;i++){
      if(a[i]==a[i+1]||d==(a[i+1]>a[i]))break;
      d=(a[i+1]>a[i]);
    }
    if(i==a.size()-1){
      zzm=true;
    }
  }
  cout<<(zzn(b)-zzn(a)+10000+zzm)%10000<<endl;
  return 0;
}