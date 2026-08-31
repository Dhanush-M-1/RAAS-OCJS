#include<bits/stdc++.h>
using namespace std;
int main(){int a=0,w=0,r=0,t=0,s;cin>>s;string d;
           for(int i=0;i<s;i++){cin>>d;if(d=="AC")a++;else if(d=="WA")w++;else if(d=="RE")r++;else t++;}
cout<<"AC x "<<a<<endl;cout<<"WA x "<<w<<endl;
           cout<<"TLE x "<<t<<endl;
           cout<<"RE x "<<r<<endl;}