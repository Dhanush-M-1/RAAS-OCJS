#include<bits/stdc++.h>
using namespace std;
int main()
{
 int n,a=0,r=0,t=0,w=0;
 cin>>n;
 string s;
 while(n--)
 {
     cin>>s;
     if(s=="AC")a++;
     if(s=="TLE")t++;
     if(s=="RE")r++;
     if(s=="WA")w++;
 }
 cout<<"AC x "<<a<<"\nWA x "<<w<<"\nTLE x "<<t<<"\nRE x "<<r;

    return 0;
}


