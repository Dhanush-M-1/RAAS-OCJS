#include <iostream>

using namespace std;

int main()
{
    int t,i,f[1000]={0},b[100000];
    string a;
    cin>>t;
    for(i=0;i<t;i++){
    cin>>a;
    b[i]=a[0];
    f[b[i]]++;
    }
    cout<<"AC x "<<f['A']<<endl;
    cout<<"WA x "<<f['W']<<endl;
    cout<<"TLE x "<<f['T']<<endl;
    cout<<"RE x "<<f['R']<<endl;
}
