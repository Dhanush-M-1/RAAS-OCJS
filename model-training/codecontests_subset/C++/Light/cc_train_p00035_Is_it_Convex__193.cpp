#include <iostream>

using namespace std;

int main()
{
    while(true){
        double xa, ya, xb, yb, xc, yc, xd, yd;
        if(!(cin>>xa)) break;
        cin.ignore();
        cin>>ya;
        cin.ignore();
        cin>>xb;
        cin.ignore();
        cin>>yb;
        cin.ignore();
        cin>>xc;
        cin.ignore();
        cin>>yc;
        cin.ignore();
        cin>>xd;
        cin.ignore();
        cin>>yd;
    
        double pc = (xb-xd)*(yc-yd)-(yb-yd)*(xc-xd);
        double qc = (xa-xd)*(yc-yd)-(ya-yd)*(xc-xd);
        double  m = (xa-xc)*(yb-yd)-(ya-yc)*(xb-xd);
        
        double p=pc/m, q=qc/m;
        if(0<=p&&p<=1 && 0<=q&&q<=1) cout<<"YES\n";
        else cout<<"NO\n";
    }
    return 0;
}