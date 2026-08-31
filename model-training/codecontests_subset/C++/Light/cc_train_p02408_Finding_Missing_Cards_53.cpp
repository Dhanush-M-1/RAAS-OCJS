#include <math.h>
#include <iostream>
#include <algorithm>
#include <vector>
#include <bits/stdc++.h>
#include <stdlib.h>
using namespace std;

int main()
{
int n;
cin >> n;
vector<vector<bool>> cards(4,vector<bool>(13));
string SHCD="SHCD";
for(int i=0;i<n;i++)
{
char shcd;
int num;
cin >> shcd >> num;
cards.at(SHCD.find(shcd)).at(num-1)=true;
}
for(int i=0;i<4;i++)
{
for(int j=0;j<13;j++)
{
if(!cards.at(i).at(j))cout << SHCD.at(i) << " " << j+1 << endl;
}
}
}

