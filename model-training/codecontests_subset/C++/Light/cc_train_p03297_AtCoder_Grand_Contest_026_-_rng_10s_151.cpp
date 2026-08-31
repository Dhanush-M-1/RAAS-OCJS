#include <iostream>
using namespace std;
typedef long long ll;
ll n,a,b,c,d,g;
ll f(ll x,ll y){
    if(y==0)return x;
    return f(y,x%y);
}
int main(void){
    cin>>n;
    for(int i=0;i<n;i++){
        cin>>a>>b>>c>>d;
        g=f(b,d);
        if(a<b||b>d){
            cout<<"No"<<endl;
            continue;
        }
        if(c>=b+1){
            cout<<"Yes"<<endl;
            continue;
        }
        if(a%g+b-g>c){
            cout<<"No"<<endl;
        }
        else cout<<"Yes"<<endl;
    }
}
