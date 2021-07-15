import React, { useState, useEffect } from "react";
import { Button } from "react-bootstrap";
import { useHistory } from "react-router";
import NavigationBar from "../Navbar/NavigationBar";
import OfferList from "../OfferList";

export default function ViewAllReceivedOffers(props) {
  return (
    <div>
      <NavigationBar />
      <h1>Received Offers</h1>
      <OfferList view="all"/>
    </div>
  );
}
