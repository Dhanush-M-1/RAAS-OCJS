#include<bits/stdc++.h>
#include<stdio.h> //per fare input output con scanf and printf
#include<stdlib.h> //per fare qsort e bsearch
#include<string.h> // per fare strcpy(sarrivo, spartenza) strcat(str, aggiungo) strcmp(a,b) che da 0 se sono uguali
#include<math.h>
#include<algorithm>
#include<iostream>
#include<queue>
#include<stack>
#include<vector>
#include<map>

#using namespace std;

#define REP(n) for(int i = 0; i < (n); i++)
#define endl '\n'
#define ld long double
#define ll long long int
#define vi vector <int> 
#define pi pair <int, int>
#define make(type, x) type (x); cin>>(x)
#define print(x) cout<<x<<endl
#define binary(v, el) binary_search((v).begin(), (v).end(), (el))

n = int(input())
s = str(input())
c0=0
c1=0
for i in range(n):
    if s[i] == '0':
        c0 += 1
    else:
        c1 += 1
if c1 != c0:
    print(1)
    print(s)
else:
    print(2)
    print(s[0] + " " + s[1:])